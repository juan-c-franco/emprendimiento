/*!
 * FullCalendar v4.0.0-alpha.2
 * Docs & License: https://fullcalendar.io/
 * (c) 2018 Adam Shaw
 */
(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory(require("fullcalendar"), require("superagent"));
	else if(typeof define === 'function' && define.amd)
		define(["fullcalendar", "superagent"], factory);
	else if(typeof exports === 'object')
		factory(require("fullcalendar"), require("superagent"));
	else
		factory(root["FullCalendar"], root["superagent"]);
})(typeof self !== 'undefined' ? self : this, function(__WEBPACK_EXTERNAL_MODULE_0__, __WEBPACK_EXTERNAL_MODULE_64__) {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 212);
/******/ })
/************************************************************************/
/******/ ({

/***/ 0:
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_0__;

/***/ }),

/***/ 212:
/***/ (function(module, exports, __webpack_require__) {

Object.defineProperty(exports, "__esModule", { value: true });
var request = __webpack_require__(64);
var fullcalendar_1 = __webpack_require__(0);
// TODO: expose somehow
var API_BASE = 'https://www.googleapis.com/calendar/v3/calendars';
var STANDARD_PROPS = {
    url: String,
    googleCalendarApiKey: String,
    googleCalendarId: String,
    data: null
};
fullcalendar_1.registerEventSourceDef({
    parseMeta: function (raw) {
        if (typeof raw === 'string') {
            raw = { url: raw };
        }
        if (typeof raw === 'object') {
            var standardProps = fullcalendar_1.refineProps(raw, STANDARD_PROPS);
            if (!standardProps.googleCalendarId && standardProps.url) {
                standardProps.googleCalendarId = parseGoogleCalendarId(standardProps.url);
            }
            delete standardProps.url;
            if (standardProps.googleCalendarId) {
                return standardProps;
            }
        }
        return null;
    },
    fetch: function (arg, onSuccess, onFailure) {
        var calendar = arg.calendar;
        var meta = arg.eventSource.meta;
        var apiKey = meta.googleCalendarApiKey || calendar.opt('googleCalendarApiKey');
        if (!apiKey) {
            onFailure({
                message: 'Specify a googleCalendarApiKey. See http://fullcalendar.io/docs/google_calendar/'
            });
        }
        else {
            var url = buildUrl(meta);
            var requestParams_1 = buildRequestParams(arg.range, apiKey, meta.data, calendar.dateEnv);
            request.get(url)
                .query(requestParams_1)
                .end(function (error, res) {
                // make an error object with more info if we can
                if (res && res.body && res.body.error) {
                    error = {
                        message: 'Google Calendar API: ' + res.body.error.message,
                        response: res,
                        errors: res.body.error.errors
                    };
                }
                if (error) {
                    onFailure(error);
                }
                else {
                    onSuccess({
                        rawEvents: gcalItemsToRawEventDefs(res.body.items, requestParams_1.timeZone),
                        response: res
                    });
                }
            });
        }
    }
});
function parseGoogleCalendarId(url) {
    var match;
    // detect if the ID was specified as a single string.
    // will match calendars like "asdf1234@calendar.google.com" in addition to person email calendars.
    if (/^[^\/]+@([^\/\.]+\.)*(google|googlemail|gmail)\.com$/.test(url)) {
        return url;
    }
    else if ((match = /^https:\/\/www.googleapis.com\/calendar\/v3\/calendars\/([^\/]*)/.exec(url)) ||
        (match = /^https?:\/\/www.google.com\/calendar\/feeds\/([^\/]*)/.exec(url))) {
        return decodeURIComponent(match[1]);
    }
}
function buildUrl(meta) {
    return API_BASE + '/' + encodeURIComponent(meta.googleCalendarId) + '/events';
}
function buildRequestParams(range, apiKey, extraData, dateEnv) {
    var params;
    var startStr;
    var endStr;
    if (dateEnv.canComputeOffset) {
        // strings will naturally have offsets, which GCal needs
    StartStr = dateEnv.formatIso(range.start);
        endStr = dateEnv.formatIso(range.end);
    }
    else {
        // when timezone isn't known, we don't know what the UTC offset should be, so ask for +/- 1 day
        // from the UTC day-start to guarantee we're getting all the events
        // (start/end will be UTC-coerced dates, so toISOString is okay)
    StartStr = fullcalendar_1.addDays(range.start, -1).toISOString();
        endStr = fullcalendar_1.addDays(range.end, 1).toISOString();
    }
    params = fullcalendar_1.assignTo(extraData || {}, {
        key: apiKey,
        timeMin: startStr,
        timeMax: endStr,
        singleEvents: true,
        maxResults: 9999
    });
    return params;
}
function gcalItemsToRawEventDefs(items, gcalTimezone) {
    return items.map(function (item) {
        return gcalItemToRawEventDef(item, gcalTimezone);
    });
}
function gcalItemToRawEventDef(item, gcalTimezone) {
    var url = item.htmlLink || null;
    // make the URLs for each event show times in the correct timezone
    if (url && gcalTimezone) {
        url = injectQsComponent(url, 'ctz=' + gcalTimezone);
    }
    return {
        id: item.id,
        title: item.summary,
    Start: item.start.dateTime || item.start.date,
        end: item.end.dateTime || item.end.date,
        url: url,
        location: item.location,
        description: item.description
    };
}
// Injects a string like "arg=value" into the querystring of a URL
// TODO: move to a general util file?
function injectQsComponent(url, component) {
    // inject it after the querystring but before the fragment
    return url.replace(/(\?.*?)?(#|$)/, function (whole, qs, hash) {
        return (qs ? qs + '&' : '?') + component + hash;
    });
}


/***/ }),

/***/ 64:
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_64__;

/***/ })

/******/ });
});