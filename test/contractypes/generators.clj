(ns contractypes.generators
  (:require [clojure.test.check.generators :as gen]
            [contractypes.libbit.datetime-generators :as time-gen]
            [contractypes.schemas :as t]
            [schematron.core :as st]
            [contractypes.schemas :as t]
            [clj-time.core :as time]
            [schema.core :as s]))

(s/defn capitalize [s :- s/Str]
  (let [[f & r] s]
    (apply str (Character/toUpperCase f) r)))

(def valid-title (gen/fmap capitalize
                           (gen/such-that
                             (complement empty?) gen/string-alpha-numeric)))

(st/defgen params t/Params (gen/hash-map
                             :title valid-title
                             :start (time-gen/datetime-before (time/now))
                             :end (time-gen/datetime-before (time/now))))
;; TODO: bring in the monad and define start-date in terms of end
