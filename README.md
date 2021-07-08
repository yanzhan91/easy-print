# easy-print

[![Maven Build](https://github.com/yanzhan91/easy-print/actions/workflows/maven.yml/badge.svg)](https://github.com/yanzhan91/easy-print/actions/workflows/maven.yml)
[![MIT License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/yanzhan91/easy-print/blob/main/LICENSE)

Never use `system.out.println()` again!

### Features

1. `print(...)` or `p(...)` to replace `system.out.println()`
2. Toggle on/off prints in higher environments with `EasyPrint.enable(false)` or using environment variable `EASYPRINT_ENABLED = false`
3. Spy on method parameters allowing you to know exactly what you're passing in. See below for examples.
4. Display package, class, method, line number, and even the type of printed argument. Reduce output verbiage by optionally toggling on/off configurations.
    
### Usage
```
<groupId>io.github.yanzhan91</groupId>
<artifactId>easy-print</artifactId>
<version>{version}</version>
```
```
import static EasyPrint.print;
import static EasyPrint.p;

print("I'm printing a string")
p("This is a shorter method name")

int a = 3;
int b = 4;
int c = 5;
boolean result = isPythagoreanTriple(p(a), p(b), p(c));
print(result)
```
```
>>> com.package.class_name > method_name:line_number (java.lang.String) - I'm printing a string
>>> com.package.class_name > method_name:line_number (java.lang.String) - This is a shorter method name
>>> com.package.class_name > method_name:line_number (java.lang.Integer) - 3
>>> com.package.class_name > method_name:line_number (java.lang.Integer) - 4
>>> com.package.class_name > method_name:line_number (java.lang.Integer) - 5
>>> com.package.class_name > method_name:line_number (java.lang.Boolean) - true
```

### Customization

```
EasyPrint.enable(true)
EasyPrint.setShowLineNumber(true)
EasyPrint.setShowType(true)
```
Or with environment variables (this takes precedence)
```
EASYPRINT_ENABLED = false
EASYPRINT_SHOWLINENUMBER = false
EASYPRINT_SHOWTYPE = false 
```
