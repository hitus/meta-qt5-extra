SUMMARY = "Baloo provides searching and indexing infrastucture with an emphasis on files"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"

inherit kde-kf5 cmake_auto_align_paths cmake_lib gtk-icon-cache

DEPENDS += " \
    ki18n \
    kconfig \
    kconfig-native \
    kauth-native \
    kidletime \
    kcrash \
    solid \
    kio \
    kdbusaddons \
    kitemmodels \
    kfilemetadata \
    kcoreaddons-native \
    \
    xapian-core \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "60d2c8c332a119500091e7263f973cb3"
SRC_URI[sha256sum] = "90ad2f2e13a33b74030fb4b26e46aa699525009efe30cf0c09283dfa52d818e2"

SRC_URI += " \
    file://0001-fix-build-for-QT_NO_SESSIONMANAGER.patch \
    file://baloo_file.desktop \
"

do_install_append() {
   install -d ${D}/${sysconfdir}/skel/.config/autostart
   install -m 0644 ${WORKDIR}/baloo_file.desktop ${D}/${sysconfdir}/skel/.config/autostart/
}

CMAKE_ALIGN_SYSROOT[1] = "KF5Baloo, -S${libdir}, -s${OE_QMAKE_PATH_HOST_LIBS}"

PACKAGES =+ "${PN}-no-autostart"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/icons \
    ${datadir}/kservices5 \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-no-autostart = "${sysconfdir}/skel/.config/autostart"
