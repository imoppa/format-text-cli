This CLI tool is designed to read a text file with lines of unorganized words and format them into trimmed and sanitized output printed in the terminal.
- it will break the string into a new line by 80 characters
- it will only show one line break when there are multiples between the paragraphs

For instance,

```
This is
a badly formatted file. This line is pretty long! It's way more than 80 characters! I feel a line
wrap coming on!


This      is a second paragraph with extraneous whitespace.
```

into

```
This is a badly formatted file. This line is pretty long! It's way more than 80
characters! I feel a line wrap coming on!

This is a second paragraph with extraneous whitespace.
```

This applications may need the following areas to look at;
1. cli tool development options in java community (jcommand[https://jcommander.org/] or picoli[https://picocli.info/] and plain java implementation of it
2. data structure - what are we going to use when parsing the string; hash table? array?
3. algorithm - are we going to chunk the reading of the file in case it contains massive number of lines? how are we going to iterate or recurse?
4. performance - what are the important aspects of performance when reading many lines?
5. testability - what are the edge cases we must cover in the unit tests?
6. delivery - how are we going to deliver the compiled solution? graalvm[https://www.graalvm.org/22.0/docs/getting-started/]?
