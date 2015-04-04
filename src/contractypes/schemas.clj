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
