# cubic-path
This library helps developer to create cubic, linear and bezier background with gradient.

# Build

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency
  
	dependencies {
	        implementation 'com.github.alokverma:cubic-path:1.1'
	}
  
  # How to use
   
    <com.akki.cubiclib.BezierPath
        android:id="@+id/bz"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        app:curve_start="left"
        app:curve_type="linear"
        app:start_color="#4f4b96"
        app:end_color="#60418b"
       />

  you can pass two values in curve_start, one is left and other one is right.
  
  curve_type = "linear" || "bezier" || "cubic"
  
  start_color and end_color is used for linear gradient
  
  you can achieve these type of view in layouts.

<img src="http://vermaalok.com/left_linear.png" alt="Left Linear" width="200"/>
<img src="http://vermaalok.com/cubic.png" alt="Cubic" width="200"/>
<img src="http://vermaalok.com/bezier_left.png" alt="Bezier left" width="200"/>
<img src="http://vermaalok.com/bezier_right.png" alt="Right Bezier" width="200"/>

  
  
