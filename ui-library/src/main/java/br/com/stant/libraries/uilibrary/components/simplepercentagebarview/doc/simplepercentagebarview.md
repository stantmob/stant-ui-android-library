# Stant UI Android Library

## Simple Percentage Bar View
> A custom view show executed quantity and dinamical selected quantity bars.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/simplepercentagebarview/doc/simple-percentage-bar-view.jpg"  width="150">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Add component to view file with your string view variable choosing card style that you want .
```xml
    <br.com.stant.libraries.uilibrary.components.simplepercentagebarview.SimplePercentageBarView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:selectedPercent="@{selectedPercentValue}"
        app:executedPercent="@{executedPercentValue}"
        />
```
