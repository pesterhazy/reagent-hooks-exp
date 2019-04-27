(ns ^:figwheel-hooks hooks.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as r]))

(defn get-app-element []
  (gdom/getElement "app"))

(defn fun-ui []
  (r/as-element [:div "from reagent"]))

(defn main-ui []
  [:> fun-ui])

(defn mount [el]
  (r/render-component [main-ui] el))

(defn ^:export init []
  (when-let [el (get-app-element)]
    (mount el)))

(defn ^:after-load on-reload []
  (init))
