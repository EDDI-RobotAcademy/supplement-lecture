import logging

from fastapi.logger import logger

# create logger
logger.setLevel(logging.DEBUG)

# create console handler and set level to debug
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)

# create formatter
class CustomFormatter(logging.Formatter):
    """Logging Formatter to add colors and count warning / errors"""

    grey = "\x1b[38;21m"
    green = "\x1b[32;1m"
    yellow = "\x1b[33m"
    red = "\x1b[31m"
    bold_red = "\x1b[31;1m"
    reset = "\x1b[0m"
    debug_format = "%(levelname)s:    %(asctime)s - [%(filename)s:%(lineno)d] - %(message)s"
    info_format = "%(levelname)s:     %(asctime)s - [%(filename)s:%(lineno)d] - %(message)s"
    warning_format = "%(levelname)s:  %(asctime)s - [%(filename)s:%(lineno)d] - %(message)s"
    error_format = "%(levelname)s:    %(asctime)s - [%(filename)s:%(lineno)d] - %(message)s"
    critical_format = "%(levelname)s: %(asctime)s - [%(filename)s:%(lineno)d] - %(message)s"

    FORMATS = {
        logging.DEBUG: grey + debug_format + reset,
        logging.INFO: green + info_format + reset,
        logging.WARNING: yellow + warning_format + reset,
        logging.ERROR: red + error_format + reset,
        logging.CRITICAL: bold_red + critical_format + reset
    }

    def format(self, record):
        log_fmt = self.FORMATS.get(record.levelno)
        formatter = logging.Formatter(log_fmt)
        return formatter.format(record)

# add formatter to ch
ch.setFormatter(CustomFormatter())

# add ch to logger
logger.addHandler(ch)

'''
'application' code
logger.debug('debug message')
logger.info('info message')
logger.warning('warn message')
logger.error('error message')
logger.critical('critical message')
'''

def init_loggers():
    pass