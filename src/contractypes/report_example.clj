(ns contractypes.report-example
  (:require [schema.core :as s]))

(declare fetch-events analyze-ad-performance format-report)

(defn ad-performance-report [params]
  (-> (fetch-events params)
      (analyze-ad-performance params)
      format-report))



