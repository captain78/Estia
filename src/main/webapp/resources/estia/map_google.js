    function showInfo(evt) {
        if (evt.features && evt.features.length) {
             highlightLayer.destroyFeatures();
             highlightLayer.addFeatures(evt.features);
             highlightLayer.redraw();
        } else {
            document.getElementById('responseText').innerHTML = evt.text;
        }
    }

    function toggleControl(element) {
        for (var key in infoControls) {
            var control = infoControls[key];
            if (element.value == key && element.checked) {
                control.activate();
            } else {
                control.deactivate(); 
            }
        }
    }

    function toggleFormat(element) {
        for (var key in infoControls) {
            var control = infoControls[key];
            control.infoFormat = element.value;
        }
    }

    function toggleLayers(element) {
        for (var key in infoControls) {
            var control = infoControls[key];
            if (element.value == 'Specified') {
                control.layers = [akinita];
            } else {
                control.layers = null;
            }
        }
    }