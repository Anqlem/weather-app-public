import * as React from "react";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import { debounce } from "@mui/material/utils";

const BACKEND_URL = process.env.REACT_APP_BACKEND_URL || "http://localhost:8080/api";

export default function AutoComplete(props) {
    const [value, setValue] = React.useState(null);
    const [inputValue, setInputValue] = React.useState("");
    const [options, setOptions] = React.useState([]);

    function handleOnSearch(value) {
        props.onKeyPress(value.description);
        setValue(null);
    }

    const fetchPredictions = React.useMemo(
        () =>
            debounce((input, callback) => {
                fetch(`${BACKEND_URL}/places/autocomplete?input=${encodeURIComponent(input)}`)
                    .then((res) => res.json())
                    .then((data) => callback(data.predictions || []))
                    .catch(() => callback([]));
            }, 400),
        []
    );

    React.useEffect(() => {
        let active = true;

        if (inputValue === "") {
            setOptions(value ? [value] : []);
            return undefined;
        }

        fetchPredictions(inputValue, (predictions) => {
            if (active) {
                let newOptions = [];

                if (value) {
                    newOptions = [value];
                }

                if (predictions) {
                    newOptions = [...newOptions, ...predictions];
                }

                setOptions(newOptions);
            }
        });

        return () => {
            active = false;
        };
    }, [value, inputValue, fetchPredictions]);

    return (
        <Autocomplete
            className={props.className}
            getOptionLabel={(option) =>
                typeof option === "string" ? option : option.description
            }
            onKeyPress={(e) => {
                if (e.key === "Enter") {
                    handleOnSearch(value);
                }
            }}
            filterOptions={(x) => x}
            options={options}
            autoComplete
            includeInputInList
            filterSelectedOptions
            autoHighlight
            value={value}
            noOptionsText="No locations"
            onChange={(event, newValue) => {
                setOptions(newValue ? [newValue, ...options] : options);
                setValue(newValue);
            }}
            onInputChange={(event, newInputValue) => {
                setInputValue(newInputValue);
            }}
            renderInput={(params) => (
                <TextField {...params} label="Search" fullWidth />
            )}
        />
    );
}

export { AutoComplete };
