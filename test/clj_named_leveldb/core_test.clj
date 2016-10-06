(ns clj-named-leveldb.core-test
  (:require [clojure.test :refer :all]
            [clj-named-leveldb.core :refer :all]
            [clj-leveldb :as leveldb]))

(deftest test-correctness
  (testing "Create 2 named databases and check if shit works"
    (let [db (leveldb/create-db "/tmp"
                                {:key-decoder byte-streams/to-string 
                                 :val-decoder byte-streams/to-string})

          alpha-db (make-named-db db "alpha")
          beta-db  (make-named-db db "beta")]

      (put alpha-db (str 1) (str 1))

      (put beta-db (str 2) (str 2))
      
      (is
       (= "1"
          (leveldb/get (:db alpha-db)
                       "alpha1")))

      (is
       (= "2"
          (leveldb/get (:db beta-db)
                       "beta2")))

      (is
       (nil?
        (leveldb/get (:db beta-db)
                     "beta1")))

      (is
       (nil?
        (leveldb/get (:db alpha-db)
                     "alpha2")))

      (delete alpha-db "1")
      (delete beta-db "2")

      (is
       (nil?
        (get alpha-db "1")))

      (is
       (nil?
        (get beta-db "2"))))))
