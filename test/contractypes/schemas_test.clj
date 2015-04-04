(ns contractypes.schemas-test
  (:require [clojure.test :refer [deftest is testing]]
            [contractypes.schemas :as t]
            [schema.core :as s]
            [clj-time.core :as time]))

(def one-event {:when (time/now)
                :what "show"
                :who  "abc123"})

(defn matching? [s v]
  (nil? (s/check s v)))

(deftest event-schema
  (testing "a positive example"
    (is (matching? t/Event one-event))))
