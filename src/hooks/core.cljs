(ns ^:figwheel-hooks hooks.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]))

(defn get-app-element []
  (gdom/getElement "app"))

(defn main-ui []
  [:div "hello world"])

(defn mount [el]
  (reagent/render-component [main-ui] el))

(defn ^:export init []
  (when-let [el (get-app-element)]
    (mount el)))

(defn ^:after-load on-reload []
  (init))
