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
  
  <p align="center">
  <img src="https://user-images.githubusercontent.com/7018540/63820221-0341c580-c966-11e9-88b0-bc472acb9549.jpg" width="350" >
	 <img src="https://user-images.githubusercontent.com/7018540/63820222-0341c580-c966-11e9-83f1-17b3d49b7e49.jpg" width="350" >
	 <img src="https://user-images.githubusercontent.com/7018540/63820223-03da5c00-c966-11e9-84d1-14a785bb33b2.jpg" width="350" >
  </p>
 
 curve_type = "linear" || "bezier" || "cubic"
  
  start_color and end_color is used for linear gradient
  
  

  
  
