(ns contractypes.generators
  (:require [clojure.test.check.generators :as gen]
            [contractypes.libbit.datetime-generators :as time-gen]
            [contractypes.schemas :as t]
            [clj-time.core :as time]))

(def params (gen/hash-map :title gen/string-alpha-numeric
                          :start (time-gen/datetime-before (time/now))
                          :end (time-gen/datetime-before (time/now))))
;; TODO: bring in the monad and define start-date in terms of end
