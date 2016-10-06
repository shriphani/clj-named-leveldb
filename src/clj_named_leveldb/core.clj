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
  [named-db & entries]
  (let [db    (:db named-db)
        name  (:name named-db)

        k-vs  (partition 2 entries)

        put-entries (flatten
                     (map
                      (fn [[k v]]
                        [(str name k) v])
                      k-vs))

        args (cons db
                   put-entries)]

    (apply leveldb/put
           args)))

(defn delete
  [named-db & entries]
  (let [db    (:db named-db)
        name  (:name named-db)]
    (apply leveldb/delete
           (cons db
                 (map
                  #(str name %)
                  entries)))))
