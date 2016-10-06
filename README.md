# clj-named-leveldb

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
