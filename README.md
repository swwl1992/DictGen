DictGen: A Dictionary Generator
======
A automatic generator for dictionary SQL.
It goes into a directory named `PROJECT_DIR`,
recursively finds all the files that contain certain extensions,
extracts all the patterns from those files,
makes them into keys and values,
(and even translates the values into other languages)
and finally,
wraps the patterns into SQL's.
Release 0.01 ready.

## Setup
- Include two jars files inside `\lib` into build path. They are used for Google translate.
- Open `Config.java` and change the variables accordingly.

## Configuration
- Open `Config.java`
- `PROJECT_DIR` is the root directory where the generator starts seeking patterns.
- `EXTENSION_PATTERN_MAP` is the extension and pattern map. Each entry is a file extension (e.g. ".java") and the target patterns inside (e.g. "private String").
- `KEY_LANGUAGE_MAP` is a map of language keys and their corredponding languages.
- Use your own `HTTP_REFERRER` and `API_KEY` if you wish.

## Execution
- So far all I/O are printed directly into console.
- If you want to make it print to a file, feel free to send pull request.
