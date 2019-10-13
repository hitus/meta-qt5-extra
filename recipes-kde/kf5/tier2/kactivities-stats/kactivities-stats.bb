SUMMARY = "A library for accessing the usage data collected by the activities system"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = " \
	file://COPYING.LGPL-2;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
	file://COPYING.LGPL-2.1;md5=4fbd65380cdd255951079008b364516c \
	file://COPYING.LGPL-3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

inherit kde-kf5

DEPENDS += " \
    boost \
    kconfig \
    kconfig-native \
    kactivities \
"

# Workaround
# default_constructible_unary_fn.hpp:38:9: error: no match for 'operator==' (operand types are 'const boost::optional<std::_Bind<ActivityInfo (Activities::*(const Activities*, std::_Placeholder<1>))(const QString&) const> >' and 'int')
CXXFLAGS += "-DBOOST_DISABLE_ASSERTS"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "1bba86cf0b196637e55bb03bed7fa7f5"
SRC_URI[sha256sum] = "85f817fd3380be1e4641cb280c1b56e697bd8eabf386784f1876da2b12f5eea0"
