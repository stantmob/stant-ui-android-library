# Stant UI Android Library

## Expandable TextView
> A custom view to expand and hidden big texts with simple button.


### How to use

1. Create your string variable
```xml
    <data>
        <variable
            name="expandableText"
            type="String"/>
    </data>
```

1. Add component to view file with your string view variable
```xml
        <br.com.stant.libraries.uilibrary.components.expandabletextview.ExpandableTextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:expandableText="@{expandableText}"
            />
```



