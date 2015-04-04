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

(declare group-up summarize add-total-row add-headers)

(defn analyze-ad-performance [events params]
  (-> events
      (group-up params)
      summarize
      add-total-row
      (add-headers params)))

(defn add-headers [so-far params]
  (merge so-far (select-keys params [:title])))

(defn add-total-row [groups]
  {:groups groups})

(defn summarize [so-far]
  so-far)

(defn group-up [events params]
    [events])

(defn fetch-events [params]
  [{:who "me" :what "click" :when (time/now)}])



