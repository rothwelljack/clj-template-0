(defproject template-0 "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.9.0"]]
  
  :resource-paths [
                   "libs/processing/core.jar"
                   "libs/processing/gluegen-rt.jar"
                   "libs/processing/gluegen-rt-natives-linux-aarch64.jar"
                   "libs/processing/gluegen-rt-natives-linux-amd64.jar"
                   "libs/processing/gluegen-rt-natives-linux-armv6hf.jar"
                   "libs/processing/gluegen-rt-natives-linux-i586.jar"
                   "libs/processing/gluegen-rt-natives-macosx-universal.jar"
                   "libs/processing/gluegen-rt-natives-windows-amd64.jar"
                   "libs/processing/gluegen-rt-natives-windows-i586.jar"
                   "libs/processing/jogl-all.jar"
                   "libs/processing/jogl-all-natives-linux-aarch64.jar"
                   "libs/processing/jogl-all-natives-linux-amd64.jar"
                   "libs/processing/jogl-all-natives-linux-armv6hf.jar"
                   "libs/processing/jogl-all-natives-linux-i586.jar"
                   "libs/processing/jogl-all-natives-macosx-universal.jar"
                   "libs/processing/jogl-all-natives-windows-amd64.jar"
                   "libs/processing/jogl-all-natives-windowsi586.jar"
                   
                   "libs/beads/beads.jar"
                   "libs/beads/beads-io.jar"
                   "libs/beads/jarjar-1.0.jar"
                   "libs/beads/jl1.0.1.jar"
                   "libs/beads/mp3spi1.9.4.jar"
                   "libs/beads/org-jaudiolibs-audioservers.jar"
                   "libs/beads/org-jaudiolibs-audioservers-jack.jar"
                   "libs/beads/org-jaudiolibs-audioservers-javasound.jar"
                   "libs/beads/org-jaudiolibs-jnajack.jar"
                   "libs/beads/tools.jar"
                   "libs/beads/tritonus_aos-0.3.6.jar"
                   "libs/beads/tritonus_share.jar"]
  
  :aot [template-0.core]
  :main template-0.core)
