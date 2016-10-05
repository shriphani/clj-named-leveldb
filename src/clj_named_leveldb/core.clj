(ns clj-named-leveldb.core
  (:refer-clojure :exclude [get sync])
  (:require [clj-leveldb :as leveldb]))

(defrecord NamedDB [db name])

(defn make-named-db
  "Args:
    db: a level-db
    name: a db-name used as a key prefix"
  ([db]
   (make-named-db db ""))
  ([db name]
   (->NamedDB db name)))

(defn get
  [named-db k]
  (let [db    (:db named-db)
        name  (:name named-db)]
    (leveldb/get db
                 (str name k))))

(defn put
  [named-db k v]
  (let [db    (:db named-db)
        name  (:name named-db)]
    (leveldb/put db
                 (str name k)
                 v)))

(defn delete
  [named-db k v]
  (let [db    (:db named-db)
        name  (:name named-db)]
    (leveldb/delete db
                    (str name k))))
