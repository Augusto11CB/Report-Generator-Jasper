## How to add image as parameter from projects classpath in jasper reports
```
URL url = this.getClass().getClassLoader().getResource("pdf/my_image.tif");
parameters.put("logo", url);
```

Declaration in the report:
```
<parameter name="logo" class="java.net.URL">
    <defaultValueExpression><![CDATA[]]></defaultValueExpression>
</parameter>
```

Usage in the report.
```
<image>
   <reportElement x="100" y="30" width="135" height="30"/>
   <imageExpression><![CDATA[$P{logo}]]></imageExpression>
</image>
```

