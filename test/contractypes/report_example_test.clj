(ns contractypes.report-example-test
  (:require [clojure.test :refer [deftest is testing use-fixtures]]
            [contractypes.report-example :as subject]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(deftest ad-performance-report-test
  (testing "grouping of rows"
    (let [events []
          expected []
          result (subject/analyze-ad-performance
                   events {})]
      (is (= expected (:groups result)))))
  (testing "title in first field"
    (let [result (subject/ad-performance-report {:title "These Are Great"})
          first-cell (get-in result [:cells 0 0])]
      (is (= "These Are Great" first-cell)))))
