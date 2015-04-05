(ns contractypes.libbit.sample-one
  (:require [clojure.test.check.generators :as gen]
            [schema.core :as s]))

;; there is so much more to this function, and the why.
;; In another repository (slack-gen) I've put a schema around to "type" it
(defn sample-one [g]
  (last (gen/sample g)))