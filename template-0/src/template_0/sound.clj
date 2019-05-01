(ns sound
  (:import (net.beadsproject.beads.core AudioContext UGen Bead AudioIO AudioUtils)
           (net.beadsproject.beads.ugens
             Clock CombFilter Gain Glide Mult Noise Phasor TapIn TapOut 
             Reverb SamplePlayer LPRezFilter WaveShaper WavePlayer
             Function Envelope Clip GranularSamplePlayer OnePoleFilter)
           (net.beadsproject.beads.data
             Buffer BufferFactory Pitch
             Sample SampleManager SampleAudioFormat)))

(def ac (atom (new AudioContext)))

(def seq-freq-sq-0 (atom [220 200 195 192 222 230 236 240 242 245]))

(defn click0 [] (println "click"))

(defn set-beat-fn []
  (let [o (proxy [net.beadsproject.beads.core.Bead][]
            (messageReceived [bead] (click0)))]
    o))

(defn new-clock [bpm div] 
  (let [c (new Clock @ac (float (/ (/ 60000 bpm) div)))]
    (.addDependent (.out @ac) c)
    (.addMessageListener c (set-beat-fn))
    (atom c)))  

(defn ac-output[]
  (.out @ac))

(defn init-clock [clk] 
  (.addDependent (.out @ac) clk))
  


(defn new-mixer-line []
  (let
    [g (new Gain @ac 2) gli (new Glide @ac)]
    (.setGain g gli)
    (.setGlideTime gli (float 10))
    (.setValue gli (float 1.0))
    (.addInput (ac-output) g)
    (atom {:gain g :glide gli})))


(defn new-mixer [num] (atom
                        (loop [vmix [] i 0]
                          (if (>= i num)
                            vmix
                            (recur (conj vmix (new-mixer-line)) (inc i))))))

(def main-mix (new-mixer 32))

(defn add-to-mix [mixer ind ugen]
  (.addInput (:gain (deref (get mixer ind))) ugen))

(defn set-gain-mixer [mixer ind val]
  (.setValue (:glide (deref (get mixer ind))) val))
    

(def syn-0 (atom 
               (let 
                 [
                  g (new Gain @ac 2)
                  gli (new Glide @ac 1.0)
                  osc (new WavePlayer @ac (float 666) (Buffer/SQUARE))
                  pitchgli (new Glide @ac 120)]
                 (.setFrequency osc pitchgli)
                 (.setGain g gli)
                 (.addInput g osc)
                 ;(add-to-mix main-mix 0 g)
                 {:gain g :gainenv gli :osc osc :pitchenv pitchgli})))
                              
                      
(defn start [] 
  (.start @ac)
  (def testline (new-mixer-line))
  (def clk0 (new-clock 120 8))
  ;(println (deref (get @main-mix 0)))
  (println @clk0)
  (add-to-mix @main-mix 0 (:gain @syn-0))
  (set-gain-mixer @main-mix 0 0.2))
  
  
  

(defn draw []
  
  
  )
