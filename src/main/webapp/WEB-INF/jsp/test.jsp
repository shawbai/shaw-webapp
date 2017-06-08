<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>  
<html>

    <head>
        <meta charset="utf-8" />
        <title>SimpleMDE Dome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">  
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
        <style type="text/css">
            body{
                background: #eaebec;
            }
            h1{
                font-size: 50px;
                text-align: center;
            }
            .container{
                background: #fff;
                width: 800px;
                padding: 20px;
                margin: 50px auto;
            }
        </style>
    </head>

    <body>

        <h1>SimpleMDE Dome</h1>

        <div class="container">
            <textarea name="" rows="" cols="" id="editor"></textarea>
        </div>

        <script type="text/javascript">
            // Most options demonstrate the non-default behavior
            var simplemde = new SimpleMDE({
                autofocus: true,
                autosave: {
                    enabled: true,
                    uniqueId: "editor01",
                    delay: 1000,
                },
                blockStyles: {
                    bold: "__",
                    italic: "_"
                },
                element: document.getElementById("editor"),
                forceSync: true,
                hideIcons: ["guide", "heading"],
                indentWithTabs: false,
                initialValue: "SimpleMDE Dome",
                insertTexts: {
                    horizontalRule: ["", "\n\n-----\n\n"],
                    image: ["![](http://", ")"],
                    link: ["[", "](http://)"],
                    table: ["", "\n\n| Column 1 | Column 2 | Column 3 |\n| -------- | -------- | -------- |\n| Text     | Text      | Text     |\n\n"],
                },
                lineWrapping: false,
                parsingConfig: {
                    allowAtxHeaderWithoutSpace: true,
                    strikethrough: false,
                    underscoresBreakWords: true,
                },
                placeholder: "placeholder",
               /* previewRender: function(plainText) {
                    console.log(plainText)
                    return customMarkdownParser(plainText); // Returns HTML from a custom parser
                },
                previewRender: function(plainText, preview) { // Async method
                    setTimeout(function(){
                        preview.innerHTML = customMarkdownParser(plainText);
                    }, 250);

                    return "Loading...";
                },*/
                promptURLs: true,
                renderingConfig: {
                    singleLineBreaks: false,
                    codeSyntaxHighlighting: true,
                },
                shortcuts: {
                    drawTable: "Cmd-Alt-T"
                },
                showIcons: ["code", "table"],
                spellChecker: false,
                status: false,
                status: ["autosave", "lines", "words", "cursor"], // Optional usage
                status: ["autosave", "lines", "words", "cursor", {
                    className: "keystrokes",
                    defaultValue: function(el) {
                        this.keystrokes = 0;
                        el.innerHTML = "0 Keystrokes";
                    },
                    onUpdate: function(el) {
                        el.innerHTML = ++this.keystrokes + " Keystrokes";
                    }
                }], // Another optional usage, with a custom status bar item that counts keystrokes
                styleSelectedText: false,
                tabSize: 4,
                //toolbar: flase,
                //toolbarTips: false,
            });
        </script>

    </body>
</html>