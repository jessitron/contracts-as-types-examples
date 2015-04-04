(ns contractypes.schemas
  (:import (org.joda.time DateTime))
  (:require [schema.core :as s]))

(s/defschema Event (s/named
                     {:when DateTime
                      :who s/Str
                      :what s/Str}
                     "Event"))
