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
  { :cells [[(get-in report-data [:header :title])]]})

(declare group-up summarize add-total-row add-headers)

(defn passthrough [f]
  (fn [v]
    (f v)
    v))

(s/defn analyze-ad-performance :- t/ReportData
  [events :- [t/Event]
   params :- t/Params]
  (-> events
      (group-up params)
      summarize
      add-total-row
      (add-headers params)
      ((passthrough println))))

(defn add-headers [so-far params]
  (assoc so-far :header (select-keys params [:title])))

(defn add-total-row [groups]
  {:groups groups
   :total {}})

(defn summarize [so-far]
  so-far)

(s/defn group-up :- [t/Group] [events params]
  (if (seq events)
    (let [group-of-everything [events {}]]
      [group-of-everything])
    []))

(s/defn fetch-events :- [t/Event] [params]
  [{:who "me" :what "click" :when (time/now)}])

