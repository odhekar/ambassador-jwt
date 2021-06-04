<!DOCTYPE html>
<html>

<head>
    <link rel="icon" type="image/png"
        href="data:image/png;base64,AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAQAQAABMLAAATCwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaWE04WlhNx1pYTc5aWE04AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaWE2mWlhN/lpYTf9aWE3/WlhN/lpYTZVaWE0BAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAWlhNEFpYTY0AAAAAWlhN/1pYTf9aWE3/WlhN/VpYTZ1aWE0ZWlhNPlpYTY9aWE0WAAAAAAAAAAAAAAAAWlhNYlpYTepaWE3/AAAAAFpYTf9aWE3/WlhNw1pYTTFaWE0aWlhNplpYTf5aWE3/WlhN71pYTWcAAAAAAAAAAFpYTf9aWE3/WlhN/wAAAABaWE3hWlhNWU65axVNvm0UWlhNNVpYTctaWE3/WlhN/1pYTf9aWE3/AAAAAAAAAABaWE3/WlhN/1pYTf8AAAAAVndXDU2+bWpNvm3uTb5t702+bWtRnGIGWlhNY1pYTetaWE3/WlhN/wAAAAAAAAAAWlhN/1pYTf9aWE3/AAAAAE2+bblNvm3/Tb5t/02+bf9Nvm3/Tb5tuQAAAABaWE0QWlhNklpYTfsAAAAAAAAAAFpYTY1aWE37WlhN/wAAAABNvm3STb5t/02+bf9Nvm3/Tb5t/02+bdIAAAAAWlhNnVpYTRVaWE0sAAAAAAAAAABaWE0cWlhNKlpYTbcAAAAATb5t0k2+bf9Nvm3/Tb5t/02+bf9Nvm3SAAAAAFpYTf9aWE3vWlhNcwAAAAAAAAAAWlhN81pYTXZaWE0GAAAAAE2+bblNvm3/Tb5t/02+bf9Nvm3/Tb5tuAAAAABaWE3/WlhN/1pYTf8AAAAAAAAAAFpYTf9aWE3/WlhN11pYTURNvm0ETb5tak2+betNvm3rTb5talWBWgoAAAAAWlhN/1pYTf9aWE3/AAAAAAAAAABaWE3/WlhN/1pYTf9aWE3/WlhNq1pYTR5Nvm0QTb5tEFpYTVFaWE3bAAAAAFpYTf9aWE3/WlhN/wAAAAAAAAAAWlhNVlpYTeJaWE3/WlhN/1pYTcdaWE02WlhNKlpYTb9aWE3/WlhN/wAAAABaWE3/WlhN61pYTWMAAAAAAAAAAAAAAABaWE0MWlhNgVpYTVFaWE0VWlhNlVpYTftaWE3/WlhN/1pYTf8AAAAAWlhNjVpYTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaWE0BWlhNllpYTf5aWE3/WlhN/1pYTf9aWE2pAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaWE0/WlhNzlpYTc9aWE1AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/D8SivgPAADIAwAAiAEAAIgBAACIAQAAiBEAAIgRAACIEQAAiBEAAIARCn6AEQAAgBEAAMATAADwHwAA/D8AAA==">
    <title>Authentication</title>
    <style>
        body {
            font-family: sans-serif;
            font-size: 1rem;
            margin: 25px auto;
            max-width: 70%;
        }

        .panel {
            margin: 25px auto;
            border: 1px solid #C5C5C5;
            border-radius: 2px;
        }

        .panel-head {
            background-color: #F5F5F5;
            padding: 0.7rem;
        }

        .panel-body {
            padding: 0.7rem;
            font-family: Cascadia Code, Consolas, monospace;
            font-size: 0.9rem;
            line-height: 150%;
            overflow: auto;
            white-space: pre;
            scrollbar-width: none;
        }
        .panel-body::-webkit-scrollbar {
            display: none;
        }

        .panel-jwt {
            word-wrap: break-word;
            white-space: pre-wrap;
        }
    </style>
</head>

<body>
    <#if name??>
        <div class="panel">
            <div class="panel-head">User</button></div>
            <div class="panel-body">${name} (${email})</div>
        </div>
        <div class="panel">
            <div class="panel-head">JWT</div>
            <div class="panel-body panel-jwt">${token} </div>
        </div>
        <div class="panel">
            <div class="panel-head">Decoded JWT</div>
            <div class="panel-body">${decodedToken}</div>
        </div>
    </#if>
    <div class="panel">
        <div class="panel-head">Headers</div>
        <div class="panel-body">${headers}</div>
    </div>
</body>

</html>