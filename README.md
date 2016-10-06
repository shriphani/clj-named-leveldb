# clj-named-leveldb

[![Circle CI](https://circleci.com/gh/shriphani/clj-named-leveldb.svg?style=shield&circle-token=351e60b226583e6e24fece5d35f03fbb4f50d3bc)](https://circleci.com/gh/shriphani/clj-named-leveldb)


[![Clojars Project](https://img.shields.io/clojars/v/clj-named-leveldb.svg)](https://clojars.org/clj-named-leveldb)


leveldb doesn't give you named databases.

This repo uses a hack to fix that - essentially prefix keys.

## Usage

Import using:

```clojure
(require [clj-named-leveldb.core :refer :all])
```

Create a named database

```clojure
(make-named-db a-leveldb db-name)
```

Then just use `get`, `put`, `delete` as you would expect.

TODO: `batch` and `iterator`

## License

Copyright © 2016 Shriphani Palakodety

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
