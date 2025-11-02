SUMMARY = "NetworkManager extension for automatic Wi-Fi connection"
DESCRIPTION = "Installs NetworkManager, wpa-supplicant, and pre-configured Wi-Fi connection for Rock 5B+. \
Enables NetworkManager service automatically with SysV init."

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

# Tell BitBake where to find local files
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Include the Wi-Fi configuration
SRC_URI += "file://wifi_configuration.nmconnection \
            file://wlan0_activation.conf \
"

# Additional packages for Wi-Fi functionality
IMAGE_INSTALL:append = " resolvconf \
                        iw \
                        wireless-regdb \
                        wpa-supplicant \
"

# Install Wi-Fi config file
do_install:append() {
    install -d ${D}/etc/NetworkManager/system-connections
    install -m 600 ${WORKDIR}/wifi_configuration.nmconnection \
        ${D}/etc/NetworkManager/system-connections/

    # WLAN activation configuration
    install -d ${D}/etc/NetworkManager/conf.d
    install -m 644 ${WORKDIR}/wlan0_activation.conf \
        ${D}/etc/NetworkManager/conf.d/wlan0_activation.conf
}

# Auto-enable NetworkManager service for SysV init
pkg_postinst_${PN}() {
    if [ ! -z "$D" ]; then
        # During rootfs generation, skip
        exit 0
    fi
    update-rc.d networkmanager enable || true
}
