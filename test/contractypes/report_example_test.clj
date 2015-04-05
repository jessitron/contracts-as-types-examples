(ns contractypes.report-example-test
  (:require [clojure.test :refer [deftest is testing use-fixtures]]
            [contractypes.report-example :as subject]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [contractypes.libbit.sample-one :refer [sample-one]]
            [contractypes.generators :as mygen]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(deftest ad-performance-report-test
  (testing "grouping of rows"
    (with-redefs [subject/fetch-events (fn [_] [])]
      (let [events []
            expected []
            result (subject/analyze-ad-performance
                     events (sample-one mygen/params))]
        (is (= expected (:groups result))))))
  (testing "title in first field"
    (let [example-title "These Are Great"
          input-params (assoc (sample-one mygen/params) :title example-title)
          result (subject/ad-performance-report input-params)
          first-cell (get-in result [:cells 0 0])]
      (is (= "These Are Great" first-cell)))))
