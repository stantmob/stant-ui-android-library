# Stant UI Android Library

## Basic Toolbar 
> A custom view toolbar with title and subtitle.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/basictoolbarview/doc/basic_toolbar.png"  width="450">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .


2. Create your string variable, they will correspond for the string value for title and subtitle.
```xml
    <data>
        <variable
            name="title"
            type="String"/>
        <variable
            name="subtitle"
            type="String"/>
    </data>
```

3. Add component to view file with both your string view variable.
```xml
        <br.com.stant.libraries.uilibrary.components.basictoolbarview.BasicToolbarView
                    android:id="@+id/basic_toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    app:title = "@{title}"
                    app:subtitle = "@{subtitle}"/>
```

4. You can also set strings on your Activity or Fragment
```java
    mBasicToolbarViewBinding.setTitle("Title value");
    mBasicToolbarViewBinding.setSubtitle("Subtitle value");
            
```
