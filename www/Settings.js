var exec = require('cordova/exec');

exports.auto_time = function(success, error) {
    exec(success, error, "Settings", "AUTO_TIME", []);
};

exports.auto_time_zone = function(success, error) {
    exec(success, error, "Settings", "AUTO_TIME_ZONE", []);
};
