SUMMARY = "Rock 5B+ GUI Image"
DESCRIPTION = "A GUI-capable image for Radxa Rock 5B+ with Weston"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Base this image on core-image-rock5b
require core-image-rock5b.bb

# GUI packages
IMAGE_INSTALL:append = " \
    weston \
    weston-init \
    kmscube \
"

# Additional GUI tools
IMAGE_INSTALL:append = " \
    xterm \
    matchbox-terminal \
    matchbox-keyboard \
"
