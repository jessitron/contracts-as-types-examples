(ns contractypes.core-test
  (:require [clojure.test :refer :all]
            [contractypes.core :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(defspec i-like-orange 100
  (prop/for-all [n gen/int]
                (is (= :orange (favorite-color)))))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
