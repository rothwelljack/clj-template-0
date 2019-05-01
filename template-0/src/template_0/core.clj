(ns sound1.core
  (:import (processing.core PApplet PConstants PGraphics PImage)
           (processing.opengl PGraphics3D PGraphics2D PShader PGraphicsOpenGL))

  
  (:gen-class :prefix "-" :extends processing.core.PApplet))

(load "sound")


(defn -settings [this] (.size this 1400 720 (PConstants/P3D)))
(defn -setup [this] 
  (def d-env (atom {:bg (.color this 0 0 255 255)})))
  ;(sound/start)
             

(defn -draw [this]
  (.background this (:bg @d-env)))
  

(defn -main []
  (println "Hello, World!")
  (PApplet/main "sound1.core"))
