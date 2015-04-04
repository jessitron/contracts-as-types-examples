(ns contractypes.report-example
  (:require [schema.core :as s]
            [clj-time.core :as time]
            [contractypes.schemas :as t]))

(declare fetch-events analyze-ad-performance format-report)

(defn ad-performance-report [params]
  (-> (fetch-events params)
      (analyze-ad-performance params)
      format-report))

(defn format-report [report-data]
  { :cells [[(:title report-data)]]})

(declare group-up summarize add-total-row add-headers)

(s/defn analyze-ad-performance :- t/ReportData
  [events :- [t/Event]
   params :- t/Params]
  (-> events
      (group-up params)
      summarize
      add-total-row
      (add-headers params)))

(defn add-headers [so-far params]
  (merge so-far (select-keys params [:title])))

(defn add-total-row [groups]
  {:groups groups
   :total {}})

(defn summarize [so-far]
  so-far)

(defn group-up [events params]
    [events])

(s/defn fetch-events :- [t/Event] [params]
  [{:who "me" :what "click" :when (time/now)}])

