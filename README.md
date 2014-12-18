DictGen: A Dictionary Generator
======
A automatic generator for dictionary SQL.
It goes into a directory named `PROJECT_DIR`,
recursively finds all the files that contain certain extensions,
extracts all the patterns from those files,
makes them into keys and values,
and finally,
wraps the patterns into SQL's.
Release 0.02 ready.

## About release 0.02
This version does not depend on Google Translate API but it only takes files as input.

## Setup
- Prepare input file which is used to generate values in other languages.

## Configuration
- Set the encoding of console to UTF-8 (Run -> Run Configurations -> Common -> Encoding)
- Open `Config.java`
- `PROJECT_DIR` is the root directory where the generator starts seeking patterns.
- `INPUT_TRANSLATION_DIR` is a file where you put keys and their translations (in other languages).
This file must have an even number of lines.
- `EXTENSION_PATTERN_MAP` is the extension and pattern map. Each entry is a file extension (e.g. ".java") and the target patterns inside (e.g. "private String").

## Execution
- So far all I/O are printed directly into console.
- If you want to make it print to a file, feel free to send pull request.