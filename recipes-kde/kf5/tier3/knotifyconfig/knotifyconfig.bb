SUMMARY = "Configuration system for KNotify"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit kde-kf5 gettext

DEPENDS += " \
    phonon \
    kauth-native \
    kcoreaddons-native \
    kcompletion \
    kconfig \
    kconfig-native \
    ki18n \
    kio \
    kservice \
    kconfigwidgets \
    knotifications \
    kwidgetsaddons \
    kxmlgui \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "40689423f1452f9d7e05883cce93a7ec"
SRC_URI[sha256sum] = "bbd2260a98f70779415369ca1d99807bc3e57f618024b9663d2a462a74169bee"
