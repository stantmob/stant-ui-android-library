# Stant UI Android Library

## Severity Level Indicator
> A custom card with five circles that changes color according to a level enum.

### Demo

<p>
  <img src="https://raw.githubusercontent.com/stantmob/stant-ui-android-library/master/ui-library/src/main/java/br/com/stant/libraries/uilibrary/components/severitylevelindicatorview/doc/severity_level_indicator.png"  width="131">
</p>

### How to use

1. Add Library with Readme setup .
* [Back to Repository Readme](https://github.com/stantmob/stant-ui-android-library#how-add-into-your-project) .

2. Add component to view file.
```xml
        <br.com.stant.libraries.uilibrary.components.severitylevelindicatorview.SeverityLevelIndicatorView
            android:id="@+id/severity_level_indicator"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
```

3. To set severity level, use setSeverityLevel method on Activity or Fragment, receiving a Severity Level Enum value as parameter.
```java
    severityLevelIndicatorView.setSeverityLevel(SeverityLevelEnum.GRAVE);
```