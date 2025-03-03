(ns index
  (:require
   ["ink" :refer [render Box Text]]
   ["react" :as react]))

(set! process.env.FORCE_COLOR 1)

(defn Counter []
  (let [[counter setCounter] (react/useState 0)]
    (react/useEffect
     (fn []
       (let [timer (js/setInterval
                    (fn []
                      (setCounter (inc counter)))
                    1000)]
         (fn []
           (js/clearInterval timer)))))
    (react/createElement Box {:width 16
                              :borderStyle "double"}
                         (react/createElement Text {:color "green"} counter " tests passed"))))

(render (react/createElement Counter))