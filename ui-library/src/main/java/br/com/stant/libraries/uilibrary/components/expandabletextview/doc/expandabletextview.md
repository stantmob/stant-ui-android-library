# Stant UI Android Library

## Expandable TextView
> A custom view to expand and hidden big texts with simple button.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/expandabletextview/doc/expandable.png" >
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/expandabletextview/doc/hidden.png" >
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .

2. Create your string variable
```xml
    <data>
        <variable
            name="expandableText"
            type="String"/>
    </data>
```

3. Add component to view file with your string view variable
```xml
        <br.com.stant.libraries.uilibrary.components.expandabletextview.ExpandableTextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:expandableText="@{expandableText}"
            />
```



