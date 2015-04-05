(ns contractypes.libbit.datetime-generators
  (:require [clojure.test.check.generators :as gen]
            [clj-time.coerce :as coerce]
            [schema.core :as s])
  (:import (org.joda.time DateTime)))

(def beginning-of-time-ms Long/MIN_VALUE)

(s/defn datetime-before [when :- DateTime]
  (gen/fmap coerce/from-long (gen/choose beginning-of-time-ms (coerce/to-long when))))
