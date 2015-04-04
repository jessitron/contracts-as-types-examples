(ns contractypes.report-example
  (:require [schema.core :as s]
            [clj-time.core :as time]))

(declare fetch-events analyze-ad-performance format-report)

(defn ad-performance-report [params]
  (-> (fetch-events params)
      (analyze-ad-performance params)
      format-report))

(defn format-report [report-data]
  { :cells [[(:title report-data)]]})

(defn analyze-ad-performance [events params]
  (select-keys params [:title]))



(defn fetch-events [params]
  [{:who "me" :what "click" :when (time/now)}])



