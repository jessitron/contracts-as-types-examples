(ns contractypes.schemas-test
  (:require [clojure.test :refer [deftest is testing]]
            [contractypes.schemas :as t]
            [schema.core :as s]
            [clj-time.core :as time]))

(def one-event {:when (time/now)
                :what "show"
                :who  "abc123"})

(defn matches? [s v]
  (is (nil? (s/check s v))))

(deftest event-schema
  (testing "a positive example"
    (matches? t/Event one-event)))
