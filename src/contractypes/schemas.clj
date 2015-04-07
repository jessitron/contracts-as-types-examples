(ns contractypes.schemas
  (:import (org.joda.time DateTime))
  (:require [schema.core :as s]))

(s/defschema CustomerId (s/named s/Str "Customer ID"))
(s/defschema Incident   (s/named s/Str "Incident type"))    ;; could be an enum

(s/defschema Event (s/named
                     {:when DateTime
                      :who  CustomerId
                      :what Incident}
                     "Event"))

(s/defschema Summation (s/named {} "Group summary"))

(s/defschema Group (s/named [(s/one [Event] "events")
                             (s/one Summation "group sum")]
                            "Group"))

(s/defschema Totals (s/named
                      {}
                      "Report totals"))

(defn capitalized? [s]
  (not (Character/isLowerCase (first s))))

(s/defschema Headers (s/named
                       {:title (s/both
                                 s/Str
                                 (s/pred (complement empty?) "nonempty")
                                 (s/pred capitalized? "capitalized"))}
                       "Report header data"))

(s/defschema ReportData (s/named
                          {:groups [Group]
                           :header Headers
                           :total Totals}
                          "Report data"))

(s/defschema Params (s/named
                      {:title s/Str
                       :start DateTime
                       :end DateTime}
                      "Report parameters"))