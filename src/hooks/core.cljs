(ns ^:figwheel-hooks hooks.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as r]))

(def use-state js/window.React.useState)
(def use-effect js/window.React.useEffect)

(defn get-app-element []
  (gdom/getElement "app"))

(defn fun-ui []
  (let [[n setN] (use-state 0)
        _ (use-effect (fn []
                        (set! (.-title js/document) (str "You clicked " n " times"))
                        js/undefined))]
    (r/as-element
     [:div
      [:p "You clicked " n " times"]
      [:button {:on-click (fn [] (setN inc))}
       "click me"]])))

(defn main-ui []
  [:> fun-ui])

(defn mount [el]
  (r/render-component [main-ui] el))

(defn ^:export init []
  (when-let [el (get-app-element)]
    (mount el)))

(defn ^:after-load on-reload []
  (init))
